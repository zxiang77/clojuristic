// the api should call into the url and return result
// need to use uri or fqdn in request


type UserCred = { userName: string; password: string };
export const login = ({userName, password}: UserCred): Promise<string> => {
	return fetch("/api/user", {
		method: 'POST',
		body:    JSON.stringify({userName, password}),
		headers: { 'Content-Type': 'application/json' },
	}).then(e => e.text());
};

type RegisterAccount = { userName: string; password: string; email: string };
export const register = (registerAccount: RegisterAccount) => {
	fetch("/api/user/register", {
		method: 'POST',
		body:    JSON.stringify(registerAccount),
		headers: { 'Content-Type': 'application/json' },
	})
		.then(e => e.text())
		.then(e => console.log(e))
};
