import React from 'react';
import AbstractLogin from "../components/AbstractLogin";
import RegisterModal from "./RegisterModal";
import '../css/form.css';
export default class Login extends AbstractLogin {
    render() {
    	const {registerModalOpen} = this.state;
        return <div className="form-box">
            <div>
                <label>Username</label>
                <input name='userName' onChange={this.onUserNameChange} /><br/>
            </div>
            <div>
                <label>password</label>
                <input name='password' type='password' onChange={this.onPasswordChange} /><br/>
            </div>
            <div>
                <button name='submit' type="button" onClick={this.onClickLogin}>Submit</button>
                <button name='register' type="button" onClick={this.onClickRegister}>Register</button>
            </div>
			<RegisterModal
				isOpen={registerModalOpen}
				onRequestClose={this.onClickModalClose} />
        </div>;
    }
}
