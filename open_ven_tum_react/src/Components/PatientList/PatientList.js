import React from 'react';
import './PatientList.css';



class PatientList extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      patient: null,
      prevId: null
    }
    this.handleClickEvent = this.handleClickEvent.bind(this);
  }

  handleClickEvent(event) {
    if (this.state.prevId !== null) {
      document.getElementById(this.state.prevId).style.backgroundColor = "";
    }
    this.state.prevId = event.target.id;
    this.props.onClick(Number(event.target.getAttribute('value')));
    document.getElementById(event.target.id).style.backgroundColor = '#5d5c61';
  }

  render() {
    const patients = this.props.patients.map(patient => {
      return <div id={patient.id} className="Patient" onClick={this.handleClickEvent} value={patient.id}>{patient.name}</div>;
    })
    return (
      <div className="PatientList">
          {patients}
      </div>
    );
  }
}

export default PatientList;
