import React from 'react';
import AbstractLogin from "../components/AbstractLogin";
import RegisterModal from "./RegisterModal";
export default class Login extends AbstractLogin {
    render() {
    	const {registerModalOpen} = this.state;
        return <div>
            <label>Username</label>
            <input name='userName' onChange={this.onUserNameChange} /><br/>
            <label>password</label>
            <input name='password' type='password' onChange={this.onPasswordChange} /><br/>
            <button name='submit' type="button" onClick={this.onClickLogin}>Submit</button>
            <button name='register' type="button" onClick={this.onClickRegister}>Register</button>
			<RegisterModal
				isOpen={registerModalOpen}
				onRequestClose={this.onClickModalClose} />
        </div>;
    }
}
