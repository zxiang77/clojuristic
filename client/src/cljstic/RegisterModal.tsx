import React, {ChangeEventHandler, MouseEventHandler, PureComponent} from "react";
import Modal from "react-modal";
import {login, register} from "./api";
import '../css/form.css'

interface Props {
	isOpen: boolean;
	onRequestClose: MouseEventHandler<Element>;
}

interface State {
	userName: string;
	email: string;
	password: string;
}

export default class RegisterModal extends PureComponent<Props, State> {
	onUserNameChange: ChangeEventHandler<HTMLInputElement> = (e) => {
		const userName = e.target.value;
		this.setState({userName})
	};

	onPasswordChange: ChangeEventHandler<HTMLInputElement> = (e) => {
		const password = e.target.value;
		this.setState({password})
	};

	onEmailChange: ChangeEventHandler<HTMLInputElement> = (e) => {
		const email = e.target.value;
		this.setState({email})
	};


	onClickRegister: MouseEventHandler = (e) => {
		const {email, userName, password} = this.state;
		const result = register({userName, password, email});
	};

	render() {
		const {isOpen, onRequestClose} = this.props;
		return <Modal
			isOpen={isOpen}
			onRequestClose={onRequestClose}
			shouldCloseOnEsc={true}>
				<div className='loader-style'>
					<label>Username</label>
					<input name='userName' onChange={this.onUserNameChange} /><br/>
					<label>Email</label>
					<input name='email' type='email' onChange={this.onEmailChange} /><br/>
					<label>password</label>
					<input name='password' type='password' onChange={this.onPasswordChange} /><br/>
					<label />
					<button name='submit' type="button" onClick={this.onClickRegister}>Submit</button>		
				</div>
			
		</Modal>
	}
}
