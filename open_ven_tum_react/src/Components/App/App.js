import React from 'react';
import './App.css';
import SearchBar from '../SearchBar/SearchBar';
import PatientList from '../PatientList/PatientList';
import Ventilator from '../Ventilator/Ventilator';
import Features from '../Features/Features';

const user = {
  name: 'Dr. Max Mustermann'
}

const patients = [{
  id: 1,
  name: 'Josh',
  mode: 'PC/AC',
  timestamp: '03/04/2020'
},
{
  id: 2,
  name: 'Adam',
  mode: 'PC/AC',
  timestamp: '03/04/2020'
},
{
  id: 3,
  name: 'Claire Smith',
  mode: 'PC/AC',
  timestamp: '03/04/2020'
},
{
  id: 4,
  name: 'Stephanie',
  mode: 'PC/AC',
  timestamp: '03/04/2020'
},
{
  id: 5,
  name: 'Chloe',
  mode: 'PC/AC',
  timestamp: '03/04/2020'
},
{
  id: 6,
  name: 'Jack',
  mode: 'PC/AC',
  timestamp: '03/04/2020'
},
{
  id: 7,
  name: 'Lucy',
  mode: 'PC/AC',
  timestamp: '03/04/2020'
},
{
  id: 8,
  name: 'Hui',
  mode: 'PC/AC',
  timestamp: '03/04/2020'
}]

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      patient: null,
      patientList: patients
    }
    this.updateCurrentPatient = this.updateCurrentPatient.bind(this);
    this.updatePatientList = this.updatePatientList.bind(this);
  }

  updatePatientList(pattern) {
    let newList = [];
    if (pattern) {
      patients.forEach(element => {
        if (element.name.toLowerCase().includes(pattern.toLowerCase())
            || element.id.toString().includes(pattern)) {
          newList.push(element);
        }
      });
    }
    else {
      newList = patients;
    }
    this.setState({
      patientList: newList
    });
  }

  updateCurrentPatient(id) {
    let temp = null;
    patients.forEach(element => {
      if (element.id === id) {
        temp = element;
      }
    });

    this.setState({
      patient: temp
    })
  }

  render() {
    return (
      <div className="App">
        <div id="header">
          <div id="logo">
            <img src="./logo.png"></img>
          </div>
          <h1>Open-source Ventilator</h1>
          <div id="user">
            <p>{user.name}</p>
            <button id="logout">Log out</button>
          </div>
        </div>
        <div className="main">
          <div className="patients">
            <SearchBar onSearch={this.updatePatientList}/>
            <PatientList patients={this.state.patientList}
               onClick={this.updateCurrentPatient}/>
          </div>
          <Ventilator patient={this.state.patient}/>
          <Features />
        </div>
      </div>
    );
  }
}

export default App;
