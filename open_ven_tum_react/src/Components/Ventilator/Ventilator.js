import React from 'react';
import './Ventilator.css';
import TriggerSettings from '../TriggerSettings/TriggerSettings';
import Graphs from '../Graphs/Graphs';

class Ventilator extends React.Component {
  render() {
    const patient = this.props.patient;
    return (
      <div className="Ventilator">
        <div className="Ventilator-header section">
          <div className="info">{patient ? patient.name : '-'}</div>
          <div className="info">{patient ? patient.timestamp : '-'}</div>
          <div className="info">Mode: {patient ? patient.mode : '-'}</div>
        </div>
        <div className="Ventilator-content section">
          <Graphs />
          <TriggerSettings />
        </div>
        <div className="Ventilator-footer section">
        </div>
      </div>
    );
  }
}

export default Ventilator;
