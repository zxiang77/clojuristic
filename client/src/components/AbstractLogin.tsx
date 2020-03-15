import {ChangeEventHandler, MouseEventHandler, PureComponent, ReactNode} from "react";
interface Props {}

interface State {
    userName: string;
    password: string;

}
export default abstract class AbstractLogin extends PureComponent<Props, State> {
    state = {
        userName: '',
        password: '',
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
        const result = fetch('/api/user')
        // @ts-ignore
            .then(e => e.body.getReader())
            .then((e) => {
                e.read().then(({done, value}) => {
                    // @ts-ignore
                    console.log(value.toString('base64'))
                })
            })
    };

    abstract render(): ReactNode;
}