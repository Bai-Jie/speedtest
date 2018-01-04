import {backendRoot} from "./commons";

const originEnv = process.env;

beforeEach(() => {
    process.env = Object.assign({}, originEnv);
});

afterAll(() => {
    process.env = originEnv;
});



it('change BACKEND_SCHEME and backendRoot()', () => {
    process.env.REACT_APP_BACKEND_SCHEME = "http";
    expect(backendRoot()).toBe("http://localhost")
});

it('change BACKEND_HOST and backendRoot()', () => {
    process.env.REACT_APP_BACKEND_HOST = "test.host";
    expect(backendRoot()).toBe("https://test.host")
});

it('change BACKEND_PORT and backendRoot()', () => {
    process.env.REACT_APP_BACKEND_PORT = "8080";
    expect(backendRoot()).toBe("https://localhost:8080")
});

it('check default backendRoot()', () => {
    expect(backendRoot()).toBe("https://localhost")
});

