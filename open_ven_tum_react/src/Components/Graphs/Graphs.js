import React from 'react';
import './Graphs.css';

class Graphs extends React.Component {
  render() {
    return (
      <div className="Graphs">
        <div class="graph" id="paw"></div>
        <div class="graph" id="flow"></div>
        <div class="graph" id="volume"></div>
      </div>
    )
  }
}

export default Graphs;
