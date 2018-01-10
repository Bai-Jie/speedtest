import React, { Component } from 'react';
import 'typeface-roboto'
import {createMuiTheme, MuiThemeProvider} from "material-ui";
import {SpeedTestLinkList} from "./SpeedTestLinkList";

const theme = createMuiTheme({
  typography: {
    // default fontFamily: '"Roboto", "Helvetica", "Arial", sans-serif'
    fontFamily: '"Roboto", "Noto Sans", "Noto Sans CJK SC", "Helvetica", "Arial", sans-serif'
  },
});

class App extends Component {
  render() {
    return (
      <MuiThemeProvider theme={theme}>
        <SpeedTestLinkList/>
      </MuiThemeProvider>
    );
  }
}

export default App;
