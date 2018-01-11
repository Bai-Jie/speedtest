import React from 'react';
import {
  Button,
  ExpansionPanel,
  ExpansionPanelActions,
  ExpansionPanelDetails,
  ExpansionPanelSummary,
  Typography
} from "material-ui";
import ExpandMoreIcon from 'material-ui-icons/ExpandMore';
import {backendRoot} from "./configs";
import {format} from 'bytes'

export function SpeedTestLink(props) {
  const totalSize = props.blocksize * props.blockcount;
  return (
    <ExpansionPanel>
      <ExpansionPanelSummary expandIcon={<ExpandMoreIcon/>}>
        <Button
          href={`${backendRoot}/speedtest?blocksize=${props.blocksize}&blockcount=${props.blockcount}`}
          onClick={(e) => e.stopPropagation()}>
          {format(totalSize)}
        </Button>
        <span/>
      </ExpansionPanelSummary>
      <ExpansionPanelDetails>
        <Typography>
          {totalSize} B
        </Typography>
      </ExpansionPanelDetails>
      <ExpansionPanelActions>
        <Button dense color="accent" onClick={props.onClickDelete}>Delete</Button>
      </ExpansionPanelActions>
    </ExpansionPanel>
  );
}
