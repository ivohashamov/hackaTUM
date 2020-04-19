import React from 'react';
import './Graphs.css';
import Graph from '../Graph/Graph';

class Graphs extends React.Component {
  render() {
    return (
      <div className="Graphs">
        <div class="graph" id="paw">
          <Graph label="MVe (mL)" data={this.props.graphData[0]}/>
        </div>
        <div class="graph" id="flow">
          <Graph label="Flowrate (mL/min)" data={this.props.graphData[1]}/>
        </div>
        <div class="graph" id="volume">
          <Graph label="Pressure (cmH2O)" data={this.props.graphData[2]}/>
        </div>
      </div>
    )
  }
}

export default Graphs;
