import Link from "next/link";
import styles from "./menu.module.css";

const Menu = () => {
  return (
    <div className={styles.menuContainer}>
      <div className="rpgui-content">
        <p
          style={{
            fontFamily: "mic",
            fontSize: "300px",
            textAlign: "center",
            marginTop: "170px",
          }}
        >
          UPBEAT
        </p>
        <div className={styles.buttonGroup}>
          <Link href="/pages/Game">
            <button className="rpgui-button" type="button">
              <p style={{ fontFamily: "hello", marginTop: "5px" }}>START</p>
            </button>
          </Link>
          <Link href="/pages/howto">
            <button className="rpgui-button" type="button">
              <p style={{ fontFamily: "hello", marginTop: "5px" }}>
                HOW TO PLAY
              </p>
            </button>
          </Link>
          <Link href="/pages/Configuration">
            <button className="rpgui-button" type="button">
              <p style={{ fontFamily: "hello", marginTop: "5px" }}>
                SETTING CONFIG
              </p>
            </button>
          </Link>
          <Link href="/">
            <button className="rpgui-button" type="button">
              <p style={{ fontFamily: "hello", marginTop: "5px" }}>
                BACK TO GAME
              </p>
            </button>
          </Link>
        </div>
      </div>
    </div>
  );
};

export default Menu;
