import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';

import { Provider } from "react-redux";
import { store } from './app/store';
import { GoogleOAuthProvider } from '@react-oauth/google';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <GoogleOAuthProvider clientId="466946279380-4v9rto1vet76e35jlbb7eo1csu0q5410.apps.googleusercontent.com">
      <Provider store={store}>
        <App />
      </Provider>
    </GoogleOAuthProvider>
  </React.StrictMode>
);

