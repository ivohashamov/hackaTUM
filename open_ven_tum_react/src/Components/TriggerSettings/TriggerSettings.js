import React from 'react';
import './TriggerSettings.css';

const arr = [{
  parameter: 'FiO2',
  unit: '%',
  value: 10
},
{
  parameter: 'humidity',
  unit: '%',
  value: 10
},
{
  parameter: 'pressure_max',
  unit: '%',
  value: 10
},
{
  parameter: 'RR',
  unit: '%',
  value: 10
},
{
  parameter: 'VT',
  unit: '%',
  value: 10
},
{
  parameter: 'PEEP',
  unit: '%',
  value: 10
},
{
  parameter: 'IE',
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
