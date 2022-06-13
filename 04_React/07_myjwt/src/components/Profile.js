import { Button, Modal } from "react-bootstrap";
import AuthService from "../services/Auth-Service";

const Profile = () => {
  const currentUser = AuthService.getCurrentUser();
  return (
    <Modal.Dialog backdrop="static" size="lg">
      <Modal.Header closeButton>
        <Modal.Title>Profile {currentUser.username} </Modal.Title>
      </Modal.Header>

      <Modal.Body>
        <p>
          <strong>Token : </strong>
          {currentUser.token.substr(0, 20)}. . .
          {currentUser.token.substr(currentUser.token.length - 20)}
        </p>

        <p>
          <strong>Id :</strong> {currentUser.id}
        </p>
        <p>
          <strong>Email :</strong> {currentUser.email}
        </p>
        <p>
          <strong>Role : </strong>
          {currentUser.role}
        </p>
      </Modal.Body>

      <Modal.Footer>
        <Button variant="secondary">Close</Button>
        <Button variant="primary">Save changes</Button>
      </Modal.Footer>
    </Modal.Dialog>
  );
};

export default Profile;
