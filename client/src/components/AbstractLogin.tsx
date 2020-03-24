import {ChangeEventHandler, MouseEventHandler, PureComponent, ReactNode} from "react";
import {login} from "../cljstic/api";

interface Props {
    onLogin: (success: boolean) => void;
}

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


    onClickLogin: MouseEventHandler = async (e) => {
		const {userName, password} = this.state;
        const {onLogin} = this.props;
        const result = await login({userName, password});
        // todo: set cookie if needed
        onLogin(result.isAuthenticated);
    };

    // The only thing different for login should be its view
    abstract render(): ReactNode;
}
