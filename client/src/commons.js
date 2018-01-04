export function backendRoot() {
    const backendScheme = process.env.REACT_APP_BACKEND_SCHEME;
    const backendHost = process.env.REACT_APP_BACKEND_HOST;
    const backendPort = process.env.REACT_APP_BACKEND_PORT;
    return `${backendScheme}://${backendHost}` + (backendPort ? `:${backendPort}` : "");
}
