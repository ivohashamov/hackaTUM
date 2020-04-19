import React from 'react';
import './Graph.css';
import { Line } from 'react-chartjs-2';

class Graph extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      chartData: {
        labels: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9','10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20'],
        datasets: [
          {
            label: props.label,
            data: props.data,
            backgroundColor: '#7395ae',
            borderWidth: 1,
            borderColor: '#777',
            hoverBorderWidth: 3,
            hoverBorderColor: '#000',
            fontSize: 20
          }
        ]
      }
    }
  }

  render() {

    return (
      <div className="chart">
        <Line
          data={this.state.chartData}
          options={{
            maintainAspectRatio: false,
            legend: {
              display: true,
              position: 'top'
            }
          }}
        />
      </div>
    );
  }
}

export default Graph;
