import "./Button.css"
export const Button = (props) =>{
    const click= props.onClick;
    return (
        <button
        type={props.type || 'button'}
        onClick={click}
        className={props.className}
        color={props.textColor}
        style={{background:props.color}}
        disabled = {props.isDisabled || false}
        >
            {props.text}
            {props.icon}
        </button>
    )
}