import React from 'react';
import './PatientList.css';
import client from "../client";



class PatientList extends React.Component {
  constructor(props) {
    super(props);
     this.state = {
      prevId: null,
       data:null
     }
    this.handleClickEvent = this.handleClickEvent.bind(this);
  }

  handleClickEvent(event) {
    // if (this.state.prevId !== null && document.getElementById(this.state.prevId)) {
    //   document.getElementById(this.state.prevId).style.backgroundColor = "";
    // }
    //alert(event.target.id)
    //this.state.prevId = event.target.id;
    let id=event.target.getAttribute('value');
    console.log(id);
    this.props.onClick(Number(event.target.getAttribute('value')));
    client({method: 'GET', path: '/data/'+id.toString()}).done(response => {
      this.setState({data: response.entity});
    });
    console.log(this.state.data.deviceId)
    //document.getElementById(event.target.id).style.backgroundColor = '#5d5c61';
  }

  render() {
    const patients = this.props.patients.map(patient => {
      let id=patient._links.self.href.substr(patient._links.self.href.lastIndexOf("/") + 1);
      return (
        <div id={id} className="Patient" onClick={this.handleClickEvent} value={id}>
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
