import React, {PureComponent} from "react";
import {Switch, Router, Route, Redirect} from "react-router-dom";
import ComponentRoute from "./ComponentRoute";
import Login from "../Login";
import logo from "../../logo.svg";

interface Props {
	onLogin: (success: boolean) => void;
}

interface State {

}

export default class Routes extends PureComponent<Props, State> {
	render() {
		const {onLogin} = this.props;
		return <Switch>
			<Route exact path="/">
				<img src={logo} className="App-logo" alt="logo" />
			</Route>
			<Route exact path="/login">
				<div className="App">
					<header className="App-header">
						Login
						<Login onLogin={onLogin} />
					</header>
				</div>
			</Route>
			<Route path="*">
				<p>not exists</p>
			</Route>
		</Switch>
	}
}
