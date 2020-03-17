import {ChangeEventHandler, MouseEventHandler, PureComponent, ReactNode} from "react";
import {login} from "../cljstic/api";

interface Props {}

interface State {
    userName: string;
    password: string;
	registerModalOpen: boolean;

}
export default abstract class AbstractLogin extends PureComponent<Props, State> {
    state = {
        userName: '',
        password: '',
		registerModalOpen: false,
    };

	onClickRegister: MouseEventHandler<HTMLElement> = (e) => {
		this.setState({registerModalOpen: true});
	};

	onClickModalClose = () => {
		this.setState({registerModalOpen: false});
	};

    onUserNameChange: ChangeEventHandler<HTMLInputElement> = (e) => {
        const userName = e.target.value;
        this.setState({userName})
    };

    onPasswordChange: ChangeEventHandler<HTMLInputElement> = (e) => {
        const password = e.target.value;
        this.setState({password})
    };

    onClickSubmit: MouseEventHandler = (e) => {
		const {userName, password} = this.state;
        const result = login({userName, password});
    };

    abstract render(): ReactNode;
}
