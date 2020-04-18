import React from 'react';
import './PatientList.css';

const arr = [{
  name: 'Josh'
},
{
  name: 'Adam'
},
{
  name: 'Claire Smith'
},
{
  name: 'Stephanie'
},
{
  name: 'Chloe'
},
{
  name: 'Chloe'
},
{
  name: 'Chloe'
},
{
  name: 'Chloe'
}]

class PatientList extends React.Component {
  render() {
    const patients = arr.map(patient => {
      return <div className="Patient">{patient.name}</div>;
    })
    return (
      <div className="PatientList">
          {patients}
      </div>
    );
  }
}

export default PatientList;
