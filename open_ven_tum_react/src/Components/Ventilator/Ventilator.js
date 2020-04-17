import React from 'react';
import './Ventilator.css';
import TriggerSettings from '../TriggerSettings/TriggerSettings';
import Graphs from '../Graphs/Graphs';

const patient = {
  mode: 'PC/AC',
  time: '03/04/2020'
}

class Ventilator extends React.Component {
  render() {
    return (
      <div className="Ventilator">
        <div class="Ventilator-header">
          {patient.name}
        </div>
        <div class="Ventilator-content">
          <Graphs />
          <TriggerSettings />
        </div>
        <div class="Ventilator-footer">
        </div>
      </div>
    );
  }
}

export default Ventilator;
