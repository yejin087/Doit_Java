// <Device mydata={mydataApp} /> 인경우

import { Component } from "react";

// const Device = ({ mydata }) => {
//   return (
//     <div>
//       <h1>Device Component</h1>
//       {mydata.myDeviceData.map((device, index) => {
//         return (
//           <div key={index}>
//             Key : {index} <br />
//             Name : {device.Name} <br />
//             Ram : {device.Ram} <hr />
//           </div>
//         );
//       })}
//     </div>
//   );
// };

class Device extends Component {
  render() {
    const { mydata } = this.props.mydata;
    return (
      <div>
        {mydata.map((device, index) => {
          return (
            <div key={index}>
              Key : {index} <br />
              Name : {device.Name} <br />
              Ram : {device.Ram} <hr />
            </div>
          );
        })}
      </div>
    );
  }
}
export default Device;
