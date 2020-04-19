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
          <div className="info">Last Update: {patient ? patient.timestamp : '-'}</div>
          <div className="info">Mode: {patient ? patient.processedParameters.ventMode : '-'}</div>
        </div>
        <div className="Ventilator-content section">
          {patient ? <Graphs graphData={this.props.graphData}/> : placeholder}
          <TriggerSettings settings={patient ? patient.triggerSettings : null}/>
        </div>
        <div className="Ventilator-footer section">
          <div className="footer-info">vPM: {patient ? patient.processedParameters.vPM : '0'}mL</div>
          <div className="footer-info">frq: {patient ? patient.processedParameters.frq : '0'}/min</div>
          <div className="footer-info">Exp. CO2: {patient ? patient.processedParameters.expCO2 : '0'}%</div>
          <div className="footer-info">Exp. O2: {patient ? patient.processedParameters.expO2 : '0'}%</div>
        </div>
      </div>
    );
  }
}

export default Ventilator;
