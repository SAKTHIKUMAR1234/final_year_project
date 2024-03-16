import { Modal, useMantineTheme } from "@mantine/core";
import { Button } from "../Button/Button";

function SettingsModal({ modalOpened, setModalOpened, old_data }) {
  const theme = useMantineTheme();

  // const a = new FormData();

  return (
    <Modal
      overlayColor={
        theme.colorScheme === "dark"
          ? theme.colors.dark[9]
          : theme.colors.gray[2]
      }
      overlayOpacity={0.55}
      overlayBlur={3}
      size="55%"
      opened={modalOpened}
      onClose={() => setModalOpened(false)}
    >
      <form className="infoForm">
        <h3>Your info</h3>
        <div>
          <input
            type="text"
            className="infoInput"
            name="livesIN"
            value={old_data.userName}
          />
        </div>

        <div>
          <input
            type="text"
            className="infoInput"
            name="FirstName"
            value={old_data.firstName}
          />

          <input
            type="text"
            className="infoInput"
            name="LastName"
            value={old_data.lastName}
          />
        </div>

        <div>
          <input
            type="number"
            className="infoInput"
            name="worksAT"
            value={old_data.phNo}
          />
        </div>

        <div>
          <input type="date" className="input" value={old_data.dateOfBirth} />
        </div>

        <div>
          Profile Image
          <input type="file" name="profileImg" />
        </div>

        <Button className="button infoButton" text="Update" />
      </form>
    </Modal>
  );
}

export default SettingsModal;
