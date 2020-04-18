import React from 'react';
import './App.css';
import SearchBar from '../SearchBar/SearchBar';
import PatientList from '../PatientList/PatientList';
import Ventilator from '../Ventilator/Ventilator';
import Features from '../Features/Features';

class App extends React.Component {
  render() {
    return (
      <div className="App">
        <h1 id="header" >Open-source Ventilator</h1>
        <div className="main">
          <div className="patients">
            <SearchBar />
            <PatientList />
          </div>
          <Ventilator />
          <Features />
        </div>
      </div>
    );
  }
}

export default App;
