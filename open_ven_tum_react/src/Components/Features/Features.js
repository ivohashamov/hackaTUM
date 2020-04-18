import React from 'react';
import './Features.css';

class Features extends React.Component {
  render() {
    return (
      <div className="Features">
        <div className="feature-header">
          Features
        </div>
        <div className="feature-container">
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
