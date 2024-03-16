import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { create_User, fetch_get,create_post } from "../utils";

//create post action

export const createPost = createAsyncThunk(
    "createPost",
    async (data, { rejectWithValue }) => {
        try {
            const response = await create_post(
                "http://localhost:8080/api/v1/media/addMedia",
                data
            );

            return response;
        } catch (error) {
            return rejectWithValue(error);
        }
    }
);

//recommended posts
export const recommendedPosts = createAsyncThunk(
    "recommendedPosts",
    async (userId, { rejectWithValue }) => {
      try {
        const response = await fetch_get(
          `http://localhost:8080/api/v1/userRecommend/recommendedMedia/${userId}`
        );
        const result = await response.data;
  
        return result;
      } catch (error) {
  
        return rejectWithValue(error);
      }
    }
  );

export const post = createSlice({
    name: "post",
    initialState: {
        user_post: [],
        loading: false,
        error: null,
        recommended_posts:[],

    },
    reducers: {
        userPosts: (state, action) => {
            return { ...state, users: action.payload };
        },
    },
    extraReducers: (builder) => {
        builder.addCase(createPost.pending, (state) => {
            state.loading = true;
        });
        builder.addCase(createPost.fulfilled, (state, action) => {
            state.loading = false;
            state.user_post.push(action.payload);
        });
        builder.addCase(createPost.rejected, (state, action) => {
            state.loading = false;
            state.error = action.payload.message;
        });
        builder.addCase(recommendedPosts.pending, (state) => {
            state.loading = true;
          });
          builder.addCase(recommendedPosts.fulfilled, (state, action) => {
            state.loading = false;
            state.recommended_posts = action.payload;
          });
          builder.addCase(recommendedPosts.rejected, (state, action) => {
            state.loading = false;
            state.error = action.payload.message;
          });

    },
});



export default post.reducer;