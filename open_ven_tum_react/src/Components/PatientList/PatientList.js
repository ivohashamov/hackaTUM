import React from 'react';
import './PatientList.css';



class PatientList extends React.Component {
  constructor(props) {
    super(props);
    this.handleClickEvent = this.handleClickEvent.bind(this);
  }

  handleClickEvent(event) {
    this.props.onClick(Number(event.target.getAttribute('value')));
  }

  render() {
    const patients = this.props.patients.map(patient => {
      return (
        <div id={patient.id} className="Patient" onClick={this.handleClickEvent} value={patient.id}>
          <div id="status"></div>
          <p>{patient.name}</p>
        </div>);
    })
    return (
      <div className="PatientList">
          {patients}
      </div>
    );
  }
}

export default PatientList;
