import React, { Component } from 'react';
import {backendRoot} from "./configs";

class App extends Component {
  render() {
    return (
      <div className="App">
        <div><ul><li><a href={`${backendRoot}/speedtest?blocksize=10240&blockcount=102400`}>1GB</a></li></ul></div>
      </div>
    );
  }
}

export default App;
