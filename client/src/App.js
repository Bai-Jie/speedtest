import React, { Component } from 'react';
import 'typeface-roboto'
import {AppBar, createMuiTheme, Grid, MuiThemeProvider, Reboot, Toolbar, Typography, withStyles} from "material-ui";
import SpeedTestLinkList from "./SpeedTestLinkList";

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
        <Reboot />
        <Layout content={<Content/>} />
      </MuiThemeProvider>
    );
  }
}

function Layout(props) {
  return (
    <div>
      <AppBar position="static">
        <Toolbar>
          <Typography type="title" color="inherit">
            Title
          </Typography>
        </Toolbar>
      </AppBar>

      <Grid container spacing={0}>
        <Grid item xs>
          {props.leftNavigator}
        </Grid>
        <Grid item xs={12}  style={{maxWidth: 1280}}>
          {props.content}
        </Grid >
        <Grid item xs>
          {props.rightNavigator}
        </Grid>
      </Grid >
    </div>
  );
}


const Content = withStyles(
  theme => (
    {root: {padding: theme.spacing.unit * 2}}
  )
)(
  props =>
    <div className={props.classes.root}>
      <SpeedTestLinkList/>
    </div>
);

export default App;
