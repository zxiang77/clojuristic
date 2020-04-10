// the api should call into the url and return result
// need to use uri or fqdn in request

type UserCred = { userName: string; password: string };

interface LoginResponse {
	isAuthenticated: boolean;
}

export const login = async ({userName, password}: UserCred): Promise<LoginResponse> => {
	const e = await fetch("/api/user/login", {
		method: 'POST',
		body: JSON.stringify({ userName, password }),
		headers: { 'Content-Type': 'application/json' },
	});
	return await e.json();
};

type RegisterAccount = { userName: string; password: string; email: string };
export const register = async (registerAccount: RegisterAccount) => {
	console.log(JSON.stringify(registerAccount));
	const e = await fetch("/api/user/register", {
		method: 'post',
		body: JSON.stringify(registerAccount),
		headers: { 'Content-Type': 'application/json' }
	});
	const e_1 = await e.text();
	return console.log(e_1);
};
