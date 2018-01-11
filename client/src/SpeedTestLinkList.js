import React from 'react';
import {SpeedTestLink} from "./SpeedTestLink";

export function SpeedTestLinkList() {
  return ([
    <SpeedTestLink key={1} blocksize={32768} blockcount={32768}/>,
    <SpeedTestLink key={2} blocksize={10240} blockcount={10240}/>
  ]);
}
