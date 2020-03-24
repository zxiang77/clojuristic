// the api should call into the url and return result
// need to use uri or fqdn in request

type UserCred = { userName: string; password: string };

interface LoginResponse {
	isAuthenticated: boolean;
}

export const login = ({userName, password}: UserCred): Promise<LoginResponse> => {
	return fetch("/api/user/seaseme", {
		method: 'POST',
		body:    JSON.stringify({userName, password}),
		headers: { 'Content-Type': 'application/json' },
	}).then(e => e.json());
};

type RegisterAccount = { userName: string; password: string; email: string };
export const register = (registerAccount: RegisterAccount) => {
	console.log(JSON.stringify(registerAccount));
	fetch("/api/user/register", {
		method: 'post',
		body:    JSON.stringify(registerAccount),
		headers: { 'Content-Type': 'application/json' }
	})
		.then(e => e.text())
		.then(e => console.log(e))
};
