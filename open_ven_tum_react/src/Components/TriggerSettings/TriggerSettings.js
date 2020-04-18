import React from 'react';
import './TriggerSettings.css';

const defaultSettings = [{
  parameter: 'FiO2',
  unit: '%',
  value: '-'
},
{
  parameter: 'humidity',
  unit: '%',
  value: '-'
},
{
  parameter: 'pressure_max',
  unit: '%',
  value: '-'
},
{
  parameter: 'RR',
  unit: '%',
  value: '-'
},
{
  parameter: 'VT',
  unit: '%',
  value: '-'
},
{
  parameter: 'PEEP',
  unit: '%',
  value: '-'
},
{
  parameter: 'IE',
  unit: '%',
  value: '-'
}];

class TriggerSettings extends React.Component {
  render() {
    let settings = this.props.settings || defaultSettings;
    settings = settings.map(setting => {
      return (
        <div className="Setting">
          <p id="param">
            <div id="bold">{setting.parameter}</div>{setting.unit}
          </p>
          <br />
          <p id="value" class="values">{setting.value}</p>
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
