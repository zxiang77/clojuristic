import React, {PureComponent} from "react";
import {Switch, Router, Route, Redirect} from "react-router-dom";
import ComponentRoute from "./ComponentRoute";
import Login from "../Login";

interface Props {

}

interface State {

}

export default class Routes extends PureComponent<Props, State> {
	render() {
		return <Switch>
			<Route path="/">
				<Redirect to="/login" />
			</Route>
			<Route exact path="/">
				<Login />
			</Route>
			<Route path="*">
				<Login />
			</Route>
		</Switch>
	}
}
