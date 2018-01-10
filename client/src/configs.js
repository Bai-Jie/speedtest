// 请通过环境变量修改配置（如通过 <a href="https://github.com/motdotla/dotenv">.env</a> ）
// 本模块仅仅是个用于方便读物配置的工具模块

module.exports = {
  get backendScheme() {
    return process.env.REACT_APP_BACKEND_SCHEME;
  },
  get backendHost() {
    return process.env.REACT_APP_BACKEND_HOST;
  },
  get backendPort() {
    return process.env.REACT_APP_BACKEND_PORT;
  },
  get backendRoot() {
    return `${this.backendScheme}://${this.backendHost}` + (this.backendPort ? `:${this.backendPort}` : "");
  }
};
