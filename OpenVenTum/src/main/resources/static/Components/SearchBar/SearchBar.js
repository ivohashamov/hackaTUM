import React from 'react';
import './SearchBar.css';

class SearchBar extends React.Component {
  constructor(props) {
    super(props);
    this.handleSearch = this.handleSearch.bind(this);
    this.handleEnter = this.handleEnter.bind(this);
  }

  handleSearch(event) {
    let pattern = document.getElementById('search').value;
    this.props.onSearch(pattern);
  }

  handleEnter(event) {
    if (event.keyCode === 13) {
      this.handleSearch(event);
    }
  }

  render() {
    return (
      <div className="SearchBar" onKeyUp={this.handleEnter}>
        <input type="text" name="search" id="search" placeholder="Patient id/name:"
          autoComplete="off"/>
        <button type="button" id="searchBtn" onClick={this.handleSearch}>Search</button>
      </div>
    );
  }
}

export default SearchBar;
