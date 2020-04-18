import React from 'react';
import './SearchBar.css';

class SearchBar extends React.Component {
  render() {
    return (
      <div className="SearchBar">
        <input type="text" name="search" id="search" placeholder="Patient name:"/>
        <button type="button">Search</button>
      </div>
    );
  }
}

export default SearchBar;
