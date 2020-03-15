import React from 'react';
import AbstractLogin from "../components/AbstractLogin";

export default class Login extends AbstractLogin {
    render() {
        return <div>
            <label>Username</label>
            <input name='userName' onChange={this.onUserNameChange} /><br/>
            <label>password</label>
            <input name='password' type='password' onChange={this.onPasswordChange} /><br/>
            <button name='submit' type="button" onClick={this.onClickSubmit}>Submit</button>
        </div>;
    }
}
