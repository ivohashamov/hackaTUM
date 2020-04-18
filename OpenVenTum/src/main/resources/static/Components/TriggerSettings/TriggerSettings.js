import React from 'react';
import './TriggerSettings.css';

const arr = [{
  parameter: 'FiO2',
  unit: '%',
  value: 10
},
{
  parameter: 'FiO2',
  unit: '%',
  value: 10
},
{
  parameter: 'FiO2',
  unit: '%',
  value: 10
},
{
  parameter: 'FiO2',
  unit: '%',
  value: 10
},
{
  parameter: 'FiO2',
  unit: '%',
  value: 10
},
{
  parameter: 'FiO2',
  unit: '%',
  value: 10
},
{
  parameter: 'FiO2',
  unit: '%',
  value: 10
}];

class TriggerSettings extends React.Component {
  render() {
    const settings = arr.map(setting => {
      return (
        <div className="Setting">
          <p id="param">
            <div id="bold">{setting.parameter}</div>{setting.unit}
          </p>
          <br />
          <p id="value">{setting.value}</p>
        </div>
      );
    })
    return (
      <div className="TriggerSettings">
        {settings}
      </div>
    )
  }
}

export default TriggerSettings;
