import React, {PureComponent} from 'react';
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
import logo from './logo.svg';

interface Props {

}

interface State {
  isAuthenticated: boolean;
}

class App extends PureComponent<Props, State> {
  state = {
    isAuthenticated: false,
  };

  setUserAuthenticated = (isAuthenticated: boolean): void => {
    if (isAuthenticated) {
      this.setState({isAuthenticated})
    }
  };

  render() {
    const {isAuthenticated} = this.state;
    // the authenticating process first find token, if no token/ token invalid then redirect to login
    return (
        <Router>
          {isAuthenticated
              ? <img src={logo} className="App-logo" alt="logo" />
              : <div className="App">
                <header className="App-header">
                  Login
                  <Login setUserAuthenticated={this.setUserAuthenticated} />
                </header>
              </div>}
          <Routes />
        </Router>
    );
  }
}

export default App;
