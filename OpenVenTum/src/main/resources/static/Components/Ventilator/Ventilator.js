import React from 'react';
import './Ventilator.css';
import TriggerSettings from '../TriggerSettings/TriggerSettings';
import Graphs from '../Graphs/Graphs';

class Ventilator extends React.Component {
  render() {
    const patient = this.props.patient;
    const placeholder = (
      <div class="placeholder">
        <h2>Please, select a patient</h2>
        <h3>Ventilator information will be displayed in real time</h3>
      </div>
    );
    return (
      <div className="Ventilator">
        <div className="Ventilator-header section">
          <div className="info">{patient ? patient.name : '-'}</div>
          <div className="info">{patient ? patient.timestamp : '-'}</div>
          <div className="info">Mode: {patient ? patient.mode : '-'}</div>
        </div>
        <div className="Ventilator-content section">
          {patient ? <Graphs /> : placeholder}
          <TriggerSettings settings={patient ? patient.triggerSettings : null}/>
        </div>
        <div className="Ventilator-footer section">
        </div>
      </div>
    );
  }
}

export default Ventilator;
