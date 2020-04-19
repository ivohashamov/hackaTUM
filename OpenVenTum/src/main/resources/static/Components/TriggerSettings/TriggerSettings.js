import React from 'react';
import './TriggerSettings.css';

const defaultSettings = [{
  parameter: 'FiO2',
  unit: '%',
  value: '0'
},
  {
    parameter: 'humidity',
    unit: '%',
    value: '0'
  },
  {
    parameter: 'pressure_max',
    unit: 'cmH2O',
    value: '0'
  },
  {
    parameter: 'frequency',
    unit: '%',
    value: '0'
  },
  {
    parameter: 'VT',
    unit: 'mL',
    value: '0'
  },
  {
    parameter: 'PEEP',
    unit: 'cmH20',
    value: '0'
  },
  {
    parameter: 'IE',
    unit: '-',
    value: '0'
  }];

class TriggerSettings extends React.Component {
  render() {
    let settings = this.props.settings || defaultSettings;
    settings = settings.map(setting => {
      return (
          <div className="Setting">
            <div id="param">
              <div id="bold">{setting.parameter}</div>({setting.unit})
            </div>
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