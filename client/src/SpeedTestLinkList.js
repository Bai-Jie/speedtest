import React from 'react';
import {backendRoot} from "./configs";

export function SpeedTestLinkList() {
  return (
    <ul>
      <li><a href={`${backendRoot}/speedtest?blocksize=10240&blockcount=102400`}>1GB</a></li>
    </ul>
  );
}
