import React, {Component} from 'react';
import {SpeedTestLink} from "./SpeedTestLink";
import {Button} from "material-ui";

class SpeedTestLinkModel {
  constructor(blockSize, blockCount, id = Date.now()) {
    this.id = id;
    this.blockSize = blockSize;
    this.blockCount = blockCount;
  }
}

export class SpeedTestLinkList extends Component {

  constructor(props) {
    super(props);
    this.state = {
      speedTestLinks: [
        new SpeedTestLinkModel(32768, 32768, 1),
        new SpeedTestLinkModel(10240, 10240, 2)
      ]
    };
  }

  handleClickAdd() {
    this.setState(prevState => {
      const speedTestLinks = prevState.speedTestLinks.slice();
      speedTestLinks.push(new SpeedTestLinkModel(10240, 10240));
      return {speedTestLinks: speedTestLinks};
    });
  }

  handleClickDelete(id) {
    this.setState(prevState => ({
      speedTestLinks: prevState.speedTestLinks.filter(link => id !== link.id)
    }));
  }

  render() {
    const speedTestLinks = this.state.speedTestLinks
      .map(({id, blockSize, blockCount}) =>
        <SpeedTestLink
          key={id}
          blocksize={blockSize}
          blockcount={blockCount}
          onClickDelete={this.handleClickDelete.bind(this, id)}
        />
      );
    return (
      <div>
        {speedTestLinks}
        <Button raised color="primary" onClick={this.handleClickAdd.bind(this)}>Add</Button>
      </div>
    );
  }

}
