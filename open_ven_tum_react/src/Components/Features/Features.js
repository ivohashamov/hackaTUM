import React from 'react';
import './Features.css';

class Features extends React.Component {
  constructor(props) {
    super(props);
    this.handleIntervalChange = this.handleIntervalChange.bind(this);
  }

  handleIntervalChange(event) {
    this.props.onChange(Number(event.target.value))
  }

  render() {
    return (
      <div className="Features">
        <div className="feature-header">
          Features
        </div>
        <div className="feature-container">
          <div class="update-interval">
            Update interval:&nbsp;&nbsp;
            <select id="interval" onChange={this.handleIntervalChange}>
              <option value='1'>1s</option>
              <option value='3'>3s</option>
              <option value='5' selected>5s</option>
              <option value='10'>10s</option>
              <option value='15'>15s</option>
            </select>
          </div>
          <div className="free-ventilators">
            <button>
              Optimize ventilator usage
            </button>
            <div class="textfield">
            </div>
          </div>
        </div>
      </div>
    )
  }
}

export default Features;
