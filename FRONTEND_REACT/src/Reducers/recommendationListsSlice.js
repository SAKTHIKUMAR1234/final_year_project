import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { fetch_get } from "../utils";

//read action recommended user
export const recommendedUser = createAsyncThunk(
  "recommendedUser",
  async (userId, { rejectWithValue }) => {
    try {
      const response = await fetch_get(
        `http://localhost:8080/api/v1/userRecommend/recommendedUsers/${userId}`
      );
      const result = await response.data;

      return result;
    } catch (error) {
      return rejectWithValue(error);
    }
  }
);

//follow requested users
export const requestedUser = createAsyncThunk(
  "requestedUser",
  async (userId, { rejectWithValue }) => {
    try {
      const response = await fetch_get(
        `http://localhost:8080/api/v1/userRecommend/recommendedUsers/${userId}`
      );
      const result = await response.data;
      return result;
    } catch (error) {
      return rejectWithValue(error);
    }
  }
);

//notifications list
export const notificationList = createAsyncThunk(
  "notificationList",
  async (userId, { rejectWithValue }) => {
    try {
      const response = await fetch_get(
        `http://localhost:8080/api/v1/notifyUser/getNotifications/${userId}`
      );
      const result = await response.data;
      return result;
    } catch (error) {
      return rejectWithValue(error);
    }
  }
);

export const recommendationList = createSlice({
  name: "recommendationList",
  initialState: {
    user_suggestion: [],
    loading: false,
    error: null,
    requested_user: [],
    notify_list: [],
  },
  reducers: {
    recommendationLists: (state, action) => {
      return { ...state, user_suggestion: action.payload };
    },
  },
  extraReducers: (builder) => {
    builder.addCase(recommendedUser.pending, (state) => {
      state.loading = true;
    });
    builder.addCase(recommendedUser.fulfilled, (state, action) => {
      state.loading = false;
      state.user_suggestion = action.payload;
    });
    builder.addCase(recommendedUser.rejected, (state, action) => {
      state.loading = false;
      state.error = action.payload.message;
    });
    builder.addCase(requestedUser.pending, (state) => {
      state.loading = true;
    });
    builder.addCase(requestedUser.fulfilled, (state, action) => {
      state.loading = false;
      state.requested_user = action.payload;
    });
    builder.addCase(requestedUser.rejected, (state, action) => {
      state.loading = false;
      state.error = action.payload.message;
    });
    builder.addCase(notificationList.pending, (state) => {
      state.loading = true;
    });
    builder.addCase(notificationList.fulfilled, (state, action) => {
      state.loading = false;
      state.notify_list = action.payload;
    });
    builder.addCase(notificationList.rejected, (state, action) => {
      state.loading = false;
      state.error = action.payload.message;
    });
  },
});

export const { recommendationLists } = recommendationList.actions;

export default recommendationList.reducer;
