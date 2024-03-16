import { userDetail } from "../Reducers/userDetailsSlice";
import { interestList } from "../Reducers/interestListsSlice";
import { recommendationList } from "../Reducers/recommendationListsSlice";
import { applyMiddleware, combineReducers, compose, createStore } from "redux";
import thunk from "redux-thunk";
import { post } from "../Reducers/postsSlice";


const middleware = applyMiddleware(thunk);

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const reducers = combineReducers({
  list_interest: interestList.reducer,
  userDetails: userDetail.reducer,
  followSuggestion: recommendationList.reducer,
  posts:post.reducer,


});

export const store = createStore(reducers, composeEnhancers(middleware));
