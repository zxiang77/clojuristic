import React, {useState} from 'react';
import {
	BrowserRouter as Router,
	Switch,
	Route,
	Redirect,
	Link
} from "react-router-dom";
import './App.css';
import Login from './cljstic/Login'
import Routes from "./cljstic/routes/Routes";



function App() {
	const [isAuthenticated, userHasAuthenticated] = useState(false);
	const [isAuthenticating, userIsAuthenticating] = useState(true);
	// the authenticating process first find token, if no token/ token invalid then redirect to login
  return (
  	  <Router>
		<div className="App">
		  	<header className="App-header">
				Login
				<Login />
		  	</header>
		</div>
		<Routes />
  	  </Router>
  );
}

export default App;
