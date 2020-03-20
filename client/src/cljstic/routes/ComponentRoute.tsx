import React, {PureComponent} from "react";
interface Props {
	Type: React.ComponentClass;

}

interface State {
}

export default class ComponentRoute extends PureComponent<Props, State> {
	render() {
		const {Type} = this.props;
		return <Type />
	}
}
